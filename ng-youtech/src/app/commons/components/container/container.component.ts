import { Component, OnInit } from '@angular/core';
import { RouteService } from '../../services/route.service';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.scss'],
})
export class ContainerComponent implements OnInit {
  showBannerHome = false;
  isAdmin = true;
  constructor(private _routerService: RouteService) {
    this._validHomePath();
  }

  ngOnInit(): void {}

  private _validHomePath() {
    this._routerService.navigationEnd().subscribe((navigation) => {
      console.log(navigation.url);

      this.showBannerHome = navigation.url === '/';
    });
  }
}
