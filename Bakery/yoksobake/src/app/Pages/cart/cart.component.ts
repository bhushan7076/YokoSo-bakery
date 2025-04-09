import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

interface CartResponseDTO {
  productName: string;
  cartQuantity: number;
  cartPrice: number;
  cartTotal: number;
}

@Component({
  selector: 'app-cart',
  standalone: true,
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
  imports: [CommonModule]
})
export class CartComponent implements OnInit {
  cartItems: CartResponseDTO[] = [];
  custId: number = 0;
  totalAmount: number = 0;

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    const customerId = localStorage.getItem('customerId');
    if (customerId) {
      this.custId = +customerId;
      this.getCartItems();
    } else {
      alert('Please login to view cart.');
      this.router.navigate(['/login']); // or any other appropriate route
    }
  }

  getCartItems(): void {
    const payload = { custId: this.custId };

    this.http.post<CartResponseDTO[]>('http://localhost:8080/cart/customer', payload).subscribe({
      next: (data) => {
        this.cartItems = data;
        this.totalAmount = data.reduce((sum, item) => sum + (item.cartTotal || 0), 0);
      },
      error: (err) => {
        alert('No items in the cart!');
        this.cartItems = [];
        console.error('Error fetching cart:', err);
      }
    });
  }

  placeOrder(): void {
    const payload = { custId: this.custId };

    this.http.post('http://localhost:8080/cart/place', payload, { responseType: 'text' }).subscribe({
      next: (message) => {
        alert(message);
        this.router.navigate(['/order']);
      },
      error: (err) => {
        alert('Failed to place order.');
        console.error('Order placement error:', err);
      }
    });
  }
}
