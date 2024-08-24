import { NgClass } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-error-toast',
  standalone: true,
  imports: [NgClass],
  templateUrl: './error-toast.component.html',
  styleUrl: './error-toast.component.scss'
})
export class ErrorToastComponent {
    @Input() message: string = '';
    @Input() show: boolean = false;
    @Output() showChanged = new EventEmitter<boolean>();

    onClose() {
        this.show = false;
        this.showChanged.emit(this.show);
    }
}
