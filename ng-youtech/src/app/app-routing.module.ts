import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PathWeb } from './commons/config/path-web';
import { HomePageComponent } from './pages/home-page/home-page.component';

const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
  },
  {
    path: PathWeb.AUTH.register.path,
    title: PathWeb.AUTH.register.title,
    loadChildren: () =>
      import('./pages/register-page/register-page.module').then(
        (m) => m.RegisterPageModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
