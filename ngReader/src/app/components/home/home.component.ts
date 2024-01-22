import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Folklore } from '../../models/folklore';
import { FolkloreService } from '../../services/folklore.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent implements OnInit {
  folkloreList: Folklore[] = [];
  newFolklore: Folklore = new Folklore();
  selected: Folklore | null = null;
  editFolklore: Folklore | null = null;
  selectedFolklore: Folklore | null = null;

  constructor(private folkloreService: FolkloreService) {}
  ngOnInit(): void {
    this.reloadFolklore();
  }

  reloadFolklore() {
    this.folkloreService.index().subscribe({
      next: (folkloreList) => {
        this.folkloreList = folkloreList;
      },
      error: (failed) => {
        console.error('folkloreListComponent.reload: error getting folklore');
      },
    });
  }

  addFolklore(folklore: Folklore) {
    this.folkloreService.create(folklore).subscribe({
      next: (create) => {
        this.newFolklore = new Folklore();
        this.reloadFolklore();
      },
      error: (oops) => {
        console.error(
          'FolkloreListComponent.addFolklore: error creating folklore'
        );
        console.error(oops);
      },
    });
  }

  setEditFolklore() {
    this.editFolklore = Object.assign({}, this.selected);
  }

  displayTable() {
    this.selected = null;
  }



  displayFolklore(pickedFolklore: Folklore | null) {
    this.selected = pickedFolklore;
  }

  updateFolklore(folklore: Folklore) {
    console.log(folklore);
    this.folkloreService.update(folklore).subscribe({
      next: (folklore) => {
        this.editFolklore = null;
        this.selected = null;
        this.reloadFolklore();
      },
      error: (oops) => {
        console.log(
          'Folklorelistcomponent.updateFolklore: error updating folklore'
        );
        console.log(oops);
      },
    });
  }

  deleteFolklore(id: number) {
    this.folkloreService.delete(id).subscribe({
      next: (folkloreList) => {
        this.reloadFolklore();
      },
      error: (fail) => {
        console.error(
          'FolkloreListComponent.reload: error getting FolkloreList'
        );
      },
    });
  }
}
