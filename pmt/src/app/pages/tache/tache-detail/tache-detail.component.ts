import { Component, LOCALE_ID } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Historique, Tache, TacheService } from '../../../services/tache.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjetService } from '../../../services/projet.service';
import { Utilisateur } from '../../../services/api/user-api.service';
import { CommonModule, registerLocaleData } from '@angular/common';
import { ErrorToastComponent } from '../../../components/error-toast/error-toast.component';
import { ListTacheComponent } from '../../../components/list-tache/list-tache.component';
import localeFr from '@angular/common/locales/fr';

registerLocaleData(localeFr);
@Component({
  selector: 'app-tache-detail',
  standalone: true,
  providers: [{ provide: LOCALE_ID, useValue: 'fr-FR' }],
  imports: [ReactiveFormsModule, CommonModule, ErrorToastComponent, ListTacheComponent],
  templateUrl: './tache-detail.component.html',
  styleUrl: './tache-detail.component.scss'
})
export class TacheDetailComponent {
    tacheForm: FormGroup;
    currentTache: Tache = {
        nom: '',
        description: '',
        dateEcheance: new Date(),
        priorite: '',
        status: 'Crée'
    };
    currentId: number = 0;
    projetId: number = 0;
    users: Utilisateur[] = [];
    historique: Historique[] = []
    errorMessage: string = '';
    showErrorToast = false;

    constructor(private tacheService: TacheService, private activatedRoute: ActivatedRoute, private projetService: ProjetService, private router: Router) {
        // Recuperer l'id de la tache
        this.activatedRoute.params.subscribe(params => {
            const id_tacheStr = params['tacheId'];
            if (id_tacheStr != 'new'){
                const id_tache = parseInt(id_tacheStr);
                this.currentId = id_tache;
            }
        })
        // Recuperer l'id du projet
        this.activatedRoute.parent?.params.subscribe(params => {
            const idStr = params['id'];
            const id = parseInt(idStr);
            this.projetId = id;
        })
        // Verifie que l'id de la tache est un nombre et pas /new pour recuperer les informations de la tache
        if (!isNaN(this.currentId)){
            this.getCurrentTache();
        }
        this.getHistorique();
        this.tacheForm = new FormGroup({
            nom: new FormControl('', [Validators.required]),    
            description: new FormControl('', [Validators.required]),
            dateEcheance: new FormControl('', [Validators.required]),
            priorite: new FormControl('', [Validators.required]),
            status: new FormControl('', [Validators.required]),
            utilisateur: new FormControl({}, [Validators.required])
        });
    }
    
    async getCurrentTache(){
        // Recupere les informations de la tache et les met dans le formulaire
        await this.getUsers();
        this.currentTache = await this.tacheService.getDetailTache(this.currentId as number);
        const utilisateur = this.users.find(user => user.id == this.currentTache.utilisateur?.id);
        this.tacheForm.setValue({
            nom: this.currentTache.nom,
            description: this.currentTache.description,
            dateEcheance: this.currentTache.dateEcheance,
            priorite: this.currentTache.priorite,
            status: this.currentTache.status,
            utilisateur
        })
    }
    
    async getUsers(){
        this.users = await this.projetService.getUsersByProject(this.projetId);
    }
    
    async getHistorique(){
        this.historique = await this.tacheService.getHistorique(this.currentId);
    }

    onSubmit(){
        // Verifie que l'utilisateur est au moins un membre du projet et qu'il est possible de modifier la tache
        if (!this.projetService.isMember()) return this.showError("Impossible de modifier la tache. Vous devez être au moins membre du projet.", true);
        // Si la tache est nouvelle, on l'ajoute au projet sinon on la met à jour
        if(this.currentTache.id == undefined){
            this.tacheService.postTache(this.projetId, this.tacheForm.value);
        } else {
            this.tacheService.updateTache(this.currentTache.id as number,this.tacheForm.value);
        }
        // Ensuite on assigne l'utilisateur a la tache si il est different de l'utilisateur actuel
        if (this.currentTache.utilisateur?.id != this.tacheForm.value.utilisateur?.id){
            this.tacheService.assignerTache(this.tacheForm.value.utilisateur?.id, this.currentTache.id as number);
        }
        this.router.navigate(['/project', this.projetId]);
    }

    showError(message: string, show: boolean) {
        this.errorMessage = message;
        this.showErrorToast = show;
    }
}
