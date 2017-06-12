
const enum Duration {
    '1_HOUR',
    '2_5_HOURS',
    '1_DAY',
    '2_5_DAYS',
    '1_MONTH'

};
import { Skill } from '../skill';
import { User } from '../../shared';
import { Proposal } from '../proposal';
export class Job {
    constructor(
        public id?: number,
        public title?: string,
        public description?: string,
        public startDate?: any,
        public duration?: Duration,
        public mainSkill?: Skill,
        public user?: User,
        public proposal?: Proposal,
    ) {
    }
}
