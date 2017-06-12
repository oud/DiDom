
const enum ProposalStatus {
    'SENT',
    'ACCEPTED',
    'REJECTED',
    'STARTED',
    'FINISHED'

};
import { Proposal } from '../proposal';
import { User } from '../../shared';
import { Attachment } from '../attachment';
export class Message {
    constructor(
        public id?: number,
        public messageTime?: any,
        public messageText?: string,
        public proposalStatus?: ProposalStatus,
        public proposal?: Proposal,
        public user?: User,
        public attachment?: Attachment,
    ) {
    }
}
