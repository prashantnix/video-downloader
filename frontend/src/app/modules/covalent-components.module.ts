import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CovalentLayoutModule } from '@covalent/core/layout';
import { CovalentStepsModule  } from '@covalent/core/steps';
import { CovalentHttpModule } from '@covalent/http';
import { CovalentHighlightModule } from '@covalent/highlight';
import { CovalentMarkdownModule } from '@covalent/markdown';
import { CovalentDynamicFormsModule } from '@covalent/dynamic-forms';
import { CovalentBaseEchartsModule } from '@covalent/echarts/base';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  exports: [
    CovalentLayoutModule,
    CovalentStepsModule,
    CovalentHttpModule,
    CovalentHighlightModule,
    CovalentMarkdownModule,
    CovalentDynamicFormsModule,
    CovalentBaseEchartsModule,
  ]
})
export class CovalentComponentsModule { }
