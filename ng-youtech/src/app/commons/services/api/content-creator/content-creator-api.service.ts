import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IResponse } from '../base-api.model';
import { environment } from './../../../../../environments/environment';
import { IResponseContentCreator } from './content-creator-api.interface';

@Injectable({ providedIn: 'root' })
export class ContentCreatorApiService {
	constructor(private _httpClient: HttpClient) {}

	private readonly URL_CONTENT_CREATOR = `${environment.host}/content_creator`;

	getContentCreator(idContentCreator: number): Observable<IResponse<IResponseContentCreator>> {
		return this._httpClient.get<IResponse<IResponseContentCreator>>(`${this.URL_CONTENT_CREATOR}/${idContentCreator}`);
	}
}
