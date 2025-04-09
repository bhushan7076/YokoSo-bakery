import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

interface Product {
  pid: number;
  pname: string;
  pcategory: string;
  pdesc: string;
  pprice: number;
  imageUrl: string;
  quantity: number;
}

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit {
  products: Product[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.http.get<Product[]>('http://localhost:8080/customer/all').subscribe({
      next: (data) => {
        this.products = data.map(product => ({
          ...product,
          quantity: 1
        }));
      },
      error: (err) => {
        alert('Failed to load products');
        console.error('Error fetching products:', err);
      }
    });
  }

  increment(product: Product): void {
    product.quantity += 1;
  }

  decrement(product: Product): void {
    if (product.quantity > 1) {
      product.quantity -= 1;
    }
  }

  addToCart(product: Product): void {
    const customerId = localStorage.getItem('customerId');

    if (!customerId) {
      alert('Please login to add items to cart.');
      return;
    }

    const payload = {
      custId: +customerId,
      productId: product.pid,
      quantity: product.quantity
    };

    this.http.post('http://localhost:8080/customer/addToCart', payload).subscribe({
      next: () => alert(`${product.pname} added to cart!`),
      error: (err) => {
        alert('Failed to add to cart');
        console.error('Cart add error:', err);
      }
    });
  }
}
