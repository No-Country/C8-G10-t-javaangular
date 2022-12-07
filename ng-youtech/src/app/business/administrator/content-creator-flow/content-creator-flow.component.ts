import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { IResponseContentCreatorHome } from '../../../commons/services/api/home/home-api.interface';
import { HomeApiService } from '../../../commons/services/api/home/home-api.service';

@Component({
	selector: 'app-content-creator-flow',
	templateUrl: './content-creator-flow.component.html',
	styleUrls: ['./content-creator-flow.component.scss']
})
export class ContentCreatorFlowComponent implements OnInit {
	displayedColumns: string[] = ['nro', 'avatar', 'name', 'lastName', 'idPseudonym'];
	dataSource = new MatTableDataSource<IResponseContentCreatorHome>();

	constructor(private _homeApiService: HomeApiService) {}

	ngOnInit(): void {
		this._loadContentCreator();
	}

	lisContentCreator: IResponseContentCreatorHome[] = [];

	private _loadContentCreator() {
		this._homeApiService.getAllContentCreator().subscribe((response) => {
			if (response.success) {
				this.dataSource.data = response.data;
			}
		});
	}

	applyFilter(event: Event) {
		const filterValue = (event.target as HTMLInputElement).value;
		this.dataSource.filter = filterValue.trim().toLowerCase();
	}
}
