
const enum PaymentType {
    'PER_HOUR',
    'FIXED_PRICE'

};
import { User } from '../../shared';
import { Skill } from '../skill';
export class HasSkill {
    constructor(
        public id?: number,
        public paymentType?: PaymentType,
        public paymentAmont?: number,
        public user?: User,
        public skill?: Skill,
    ) {
    }
}
