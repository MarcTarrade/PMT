import { Component, Input, OnChanges } from '@angular/core';
import { Tache, TacheService } from '../../services/tache.service';
import { CommonModule } from '@angular/common';
import { FilterTachePipe } from "../../pipes/filter-tache.pipe";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-list-tache',
  standalone: true,
  imports: [CommonModule, FilterTachePipe, RouterLink],
  templateUrl: './list-tache.component.html',
  styleUrl: './list-tache.component.scss'
})
export class ListTacheComponent implements OnChanges{
    taches: Tache[] = [];
    @Input() projectId?: number;

    constructor(private tacheService: TacheService) {
    }
    ngOnChanges() {
        if (this.projectId) this.getTaches();
    }

    async getTaches() {
       this.taches = await this.tacheService.getTachesByProject(this.projectId!)
    }
}
