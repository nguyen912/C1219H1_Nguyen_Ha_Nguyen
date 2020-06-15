import { Component, OnInit } from '@angular/core';
import {DictionaryService, IWord} from "../dictionary.service";
import {Subscription} from "rxjs";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  word: IWord;
  sub: Subscription;
  constructor(
    private dictionaryService: DictionaryService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const key = paramMap.get('key');
      const meaning = this.dictionaryService.search(key);
      this.word = {
        key: key,
        meaning: meaning
      };
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

}
