import { Routes } from '@angular/router';
import { HomePageComponent } from '../../pages/home-page/home-page.component';
import { ContentCreatorComponent } from './../../pages/content-creator/content-creator.component';
import { PathWeb } from './path-web';

export const PRINCIPAL_ROUTES: Routes = [
  {
    path: '',
    component: HomePageComponent,
  },
  {
    path: PathWeb.AUTH.register.path,
    title: PathWeb.AUTH.register.title,
    loadChildren: () =>
      import('../../pages/register-page/register-page.module').then(
        (m) => m.RegisterPageModule
      ),
  },
  {
    path: PathWeb.CONTENT_CREATOR.path,
    loadChildren: () =>
      import('../../pages/content-creator/content-creator.module').then(
        (m) => m.ContentCreatorModule
      ),
  },
];

export const CONTENT_CREATOR_ROUTES: Routes = [
  {
    path: '',
    component: ContentCreatorComponent,
    children: [
      {
        path: PathWeb.CONTENT_CREATOR.profile.path,
        title: PathWeb.CONTENT_CREATOR.profile.title,
        loadChildren: () =>
          import(
            '../../pages/content-creator/profile-page/profile-page.module'
          ).then((m) => m.ProfilePageModule),
      },
      {
        path: PathWeb.CONTENT_CREATOR.broadcastMedium.path,
        title: PathWeb.CONTENT_CREATOR.broadcastMedium.title,
        loadChildren: () =>
          import(
            '../../pages/content-creator/broadcast-medium-page/broadcast-medium-page.module'
          ).then((m) => m.BroadcastMediumPageModule),
      },
      {
        path: '',
        pathMatch: 'full',
        redirectTo: PathWeb.CONTENT_CREATOR.profile.path,
      },
    ],
  },
];
