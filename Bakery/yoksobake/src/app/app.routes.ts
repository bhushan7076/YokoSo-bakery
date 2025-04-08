// src/app/app.routes.ts
import { Routes } from '@angular/router';

import { LoginComponent } from './Pages/login/login.component';
import { NavbarComponent } from './Pages/navbar/navbar.component';
import { HomeComponent } from './Pages/home/home.component';
import { ProductsComponent } from './Pages/products/products.component';
import { AboutusComponent } from './Pages/aboutus/aboutus.component';
import { ContactusComponent } from './Pages/contactus/contactus.component';
import { CartComponent } from './Pages/cart/cart.component';
import { OrderComponent } from './Pages/order/order.component';

import { authGuard } from '../services/auth.guard';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: NavbarComponent,
    children: [
      {
        path: 'home',
        component: HomeComponent,
        canActivate: [authGuard]
      },
      {
        path: 'products',
        component: ProductsComponent,
        canActivate: [authGuard]
      },
      {
        path: 'aboutus',
        component: AboutusComponent,
        canActivate: [authGuard]
      },
      {
        path: 'contact',
        component: ContactusComponent,
        canActivate: [authGuard]
      },
      {
        path: 'cart',
        component: CartComponent,
        canActivate: [authGuard]
      },
      {
        path: 'order',
        component: OrderComponent,
        canActivate: [authGuard]
      }
    ]
  },
  {
    path: '**',
    redirectTo: 'login'
  }
];
