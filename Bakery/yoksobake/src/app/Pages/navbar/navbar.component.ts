import { Component, inject } from '@angular/core';
import { Router, RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink,RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  router =inject(Router)
    logoff(){
      localStorage.removeItem('customerId');  // Remove customerId from localStorage
    alert('Logged out successfully!');
      this.router.navigateByUrl('login');
    }
}
