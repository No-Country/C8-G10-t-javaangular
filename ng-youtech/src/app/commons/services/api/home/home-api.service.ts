import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../../environments/environment';
import { IResponse } from './../base-api.model';
import { IResponseContentCreatorHome } from './home-api.interface';

const URL_CONTENT_CREATOR_HOME = environment.host + '/content_creator/all';

@Injectable({ providedIn: 'root' })
export class HomeApiService {
  constructor(private _httpClient: HttpClient) {}

  getAllContentCreator() {
    return this._httpClient.get<IResponse<IResponseContentCreatorHome[]>>(
      URL_CONTENT_CREATOR_HOME
    );
  }
}
