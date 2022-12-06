import { Component, OnInit } from '@angular/core';
import { BroadCastMediumApiService } from '../../../commons/services/api/broadcast-medium/broadcast-medium-api.service';
import { IResponseAllBroadcastMedium } from './../../../commons/services/api/broadcast-medium/broadcast-medium-api.interface';
import { DataUserService } from './../../../commons/services/local/data-user.service';

@Component({
	selector: 'app-broadcast-medium',
	templateUrl: './broadcast-medium.component.html',
	styleUrls: ['./broadcast-medium.component.scss']
})
export class BroadcastMediumComponent implements OnInit {
	constructor(
		private _broadCastMediumApiService: BroadCastMediumApiService,
		private _dataUserService: DataUserService
	) {}

	broadcastMediumList: IResponseAllBroadcastMedium[] = [];

	ngOnInit(): void {
		this._broadCastMediumApiService
			.getAllBroadcastMedium(this._dataUserService.getDataUser()!.idContentCreator)
			.subscribe((response) => {
				if (response.success) {
					this.broadcastMediumList = response.data;
				}
			});
	}
}
