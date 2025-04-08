import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { Router } from '@angular/router';


export const authGuard: CanActivateFn = (route, state) => {
  const loggedin = localStorage.getItem('customerId');
  const router= inject(Router);

  console.log(loggedin)

  if(loggedin != null){
    return true ;
  }else{
    router.navigateByUrl('login');
    return false;
  }

};
