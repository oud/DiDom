import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { DiDomUserInfoModule } from './user-info/user-info.module';
import { DiDomSkillModule } from './skill/skill.module';
import { DiDomHasSkillModule } from './has-skill/has-skill.module';
import { DiDomJobModule } from './job/job.module';
import { DiDomLocationModule } from './location/location.module';
import { DiDomCountryModule } from './country/country.module';
import { DiDomProposalModule } from './proposal/proposal.module';
import { DiDomMessageModule } from './message/message.module';
import { DiDomAttachmentModule } from './attachment/attachment.module';
import { DiDomContractModule } from './contract/contract.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        DiDomUserInfoModule,
        DiDomSkillModule,
        DiDomHasSkillModule,
        DiDomJobModule,
        DiDomLocationModule,
        DiDomCountryModule,
        DiDomProposalModule,
        DiDomMessageModule,
        DiDomAttachmentModule,
        DiDomContractModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DiDomEntityModule {}
