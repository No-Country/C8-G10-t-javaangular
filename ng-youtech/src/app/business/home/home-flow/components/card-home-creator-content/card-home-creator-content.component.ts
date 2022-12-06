import { Component, Input, OnInit } from '@angular/core';
import { ICardContentCreatorComponente } from '../../model/component.interface';

@Component({
	selector: 'app-card-home-creator-content',
	templateUrl: './card-home-creator-content.component.html',
	styleUrls: ['./card-home-creator-content.component.scss']
})
export class CardHomeCreatorContentComponent implements OnInit {
	@Input() dataCard?: ICardContentCreatorComponente;

	ngOnInit(): void {}
}
