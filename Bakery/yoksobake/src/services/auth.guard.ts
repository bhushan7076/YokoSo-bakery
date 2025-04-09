import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { isPlatformBrowser } from '@angular/common';
import { PLATFORM_ID } from '@angular/core';
import { Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const platformId = inject(PLATFORM_ID);
  const router = inject(Router);

  // ✅ Check if the code is running in the browser before using localStorage
  if (isPlatformBrowser(platformId)) {
    const loggedIn = localStorage.getItem('customerId');
    console.log(loggedIn);

    if (loggedIn !== null) {
      return true;
    } else {
      router.navigateByUrl('/login');
      return false;
    }
  }

  // In non-browser environments, block access
  return false;
};
