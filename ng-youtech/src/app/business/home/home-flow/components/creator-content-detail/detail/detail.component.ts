import { Component, Input } from '@angular/core';
import { IResponseAllBroadcastMedium } from '../../../../../../commons/services/api/broadcast-medium/broadcast-medium-api.interface';

@Component({
	selector: 'app-detail',
	templateUrl: './detail.component.html',
	styleUrls: ['./detail.component.scss']
})
export class DetailComponent {
	@Input() item!: IResponseAllBroadcastMedium;
}
