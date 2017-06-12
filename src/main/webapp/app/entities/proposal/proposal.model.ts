
const enum PaymentType {
    'PER_HOUR',
    'FIXED_PRICE'

};

const enum ProposalStatus {
    'SENT',
    'ACCEPTED',
    'REJECTED',
    'STARTED',
    'FINISHED'

};
import { Job } from '../job';
import { User } from '../../shared';
import { Message } from '../message';
import { Contract } from '../contract';
export class Proposal {
    constructor(
        public id?: number,
        public proposalTime?: any,
        public paymentType?: PaymentType,
        public paymentAmount?: number,
        public currentProposalStatus?: ProposalStatus,
        public clientGrade?: number,
        public clientComment?: string,
        public freelanceGrade?: number,
        public freelanceComment?: string,
        public job?: Job,
        public user?: User,
        public message?: Message,
        public contract?: Contract,
    ) {
    }
}
