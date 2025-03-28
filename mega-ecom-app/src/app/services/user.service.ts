import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';

import { User } from '../models/user';
import { of } from 'rxjs';
import { Register } from '../models/register.model';

@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>('http://localhost:4200/users');
    }

    register(user: User) {
        let register:Register = JSON.parse(JSON.stringify(user))

        //return this.http.post<Register>('http://productservice-env.eba-hheutahr.us-east-1.elasticbeanstalk.com/register', user);
        return this.http.post<Register>('https://bubejla797.execute-api.us-east-1.amazonaws.com/v1/customer-register-service', user);
        //return of(new HttpResponse ({ status: 200, body}))
    }

    delete(id: number) {
        return this.http.delete('http://localhost:4200/users/${id}');
        //return 0;
    }
}