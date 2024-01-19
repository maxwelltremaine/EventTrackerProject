import { Component, OnInit } from '@angular/core';
import { FolkloreService } from '../../services/folklore.service';
import { Folklore } from '../../models/folklore';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'

})
export class HomeComponent implements OnInit {

folkloreList: Folklore[] = [];

  constructor(
    private folkloreService: FolkloreService
  ) {}
   ngOnInit(): void{
    this.reloadFolklore()
  }

    reloadFolklore(){
      this.folkloreService.index().subscribe({
        next: (folkloreList) => {
          this.folkloreList = folkloreList;
        },
        error: (failed) => {
          console.error('folkloreListComponent.reload: error getting folklore');
        },
      });
    }


}
