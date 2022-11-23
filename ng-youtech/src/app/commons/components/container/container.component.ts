import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.scss'],
})
export class ContainerComponent implements OnInit {
  constructor(private _router: Router) {
    this._validHomePath();
  }
  showBannerHome = false;

  ngOnInit(): void {}

  private _validHomePath() {
    this._router.events
      .pipe(filter((value) => value instanceof NavigationEnd))
      .subscribe((event) => {
        const navigation = event as NavigationEnd;
        this.showBannerHome = navigation.url === '/';
      });
  }
}
