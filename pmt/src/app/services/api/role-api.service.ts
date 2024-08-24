import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


export interface Role {
    id: number;
    nom: string;
}

@Injectable({
  providedIn: 'root'
})
export class RoleApiService {
    private url = 'http://localhost:8090';
    constructor(private httpClient: HttpClient) { }
  
    getRoles(){
      return this.httpClient.get<Role[]>(`${this.url}/roles`);
    }
}
