import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IResponse } from '../base-api.model';
import { environment } from './../../../../../environments/environment';
import { IResponseAllBroadcastMedium } from './broadcast-medium-api.interface';

@Injectable({ providedIn: 'root' })
export class BroadCastMediumApiService {
	constructor(private _httpClient: HttpClient) {}

	private readonly URL_BROADCAST_MEDIUM = `${environment.host}/broadcast_medium`;

	getAllBroadcastMedium(idContentCreator: number) {
		return this._httpClient.get<IResponse<IResponseAllBroadcastMedium[]>>(
			`${this.URL_BROADCAST_MEDIUM}/${idContentCreator}`
		);
	}
}
