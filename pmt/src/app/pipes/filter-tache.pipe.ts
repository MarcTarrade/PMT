import { Pipe, PipeTransform } from '@angular/core';
import { Tache } from '../services/tache.service';

@Pipe({
  name: 'filterTache',
  standalone: true
})
export class FilterTachePipe implements PipeTransform {

  transform(taches: Tache[], status: string): Tache[] {
    return taches.filter(tache => tache.status === status);
  }

}
