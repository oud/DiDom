
const enum PaymentType {
    'PER_HOUR',
    'FIXED_PRICE'

};
import { Proposal } from '../proposal';
import { User } from '../../shared';
export class Contract {
    constructor(
        public id?: number,
        public startTime?: any,
        public endTime?: any,
        public paymentType?: PaymentType,
        public paymentAmount?: number,
        public proposal?: Proposal,
        public user?: User,
    ) {
    }
}
