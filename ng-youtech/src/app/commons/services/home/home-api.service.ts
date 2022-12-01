import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { IResponseContentCreatorHome } from './home-api.interface';

const URL_CONTENT_CREATOR_HOME = environment.host + '/content_creator/all';

@Injectable({ providedIn: 'root' })
export class HomeApiService {
  constructor(private _httpClient: HttpClient) {}

  getAllContentCreator(): Observable<IResponseContentCreatorHome[]> {
    return this._httpClient.get<IResponseContentCreatorHome[]>(
      URL_CONTENT_CREATOR_HOME
    );
  }
}
