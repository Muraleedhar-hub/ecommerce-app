import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../models/user';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;
    geoCodeUrl: String = 'https://geocode.arcgis.com/arcgis/rest/services/World/GeocodeServer/reverseGeocode';

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username, password) {
        return this.http.post<any>(' https://rxnw47yx57.execute-api.us-east-1.amazonaws.com/v2/login-service', 
        //{ username, password }
    
        {
            "username": "muralee",
            "password": "saanvi"
        })
            .pipe(map(user => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                return user;
            }));
    }

    logout() {
        // remove user from local storage and set current user to null
        localStorage.removeItem('currentUser');
        location.reload(true);
        this.currentUserSubject.next(null);
    }

    getLocationDetails(): Observable<any> {
        //let geoCodePositionUrl = this.geoCodeUrl + '?f=pjson&featureTypes=&location=' + sessionStorage.getItem('longitude') + ',' + sessionStorage.getItem('latitude');
        let geoCodePositionUrl = 'https://revgeocode.search.hereapi.com/v1/revgeocode?at='+localStorage.getItem('latitude')+'%2C'+localStorage.getItem('longitude')+'&lang=en-US&apiKey=5MQ5HYR43JAHnJy_klUswjVwoqJEBDD4DuE7qV0kwW0';
        return this.http.get(geoCodePositionUrl);
    }
}