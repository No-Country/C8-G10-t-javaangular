import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../../environments/environment';
import { IResponse } from './../base-api.model';
import { IResponseContentCreatorHome, IResponseTags } from './home-api.interface';

export const URL_CONTENT_CREATOR_HOME = environment.host + '/content_creator/all';
export const URL_TAGS_ACTIVES_HOME = environment.host + '/tag/actives';

@Injectable({ providedIn: 'root' })
export class HomeApiService {
	constructor(private _httpClient: HttpClient) {}

	getAllContentCreator() {
		return this._httpClient.get<IResponse<IResponseContentCreatorHome[]>>(URL_CONTENT_CREATOR_HOME);
	}

	getActiveTags() {
		return this._httpClient.get<IResponse<IResponseTags[]>>(URL_TAGS_ACTIVES_HOME);
	}
}
