
const enum TypeUser {
    'RECRUITER',
    'CANDIDATE'

};
import { User } from '../../shared';
import { Location } from '../location';
export class UserInfo {
    constructor(
        public id?: number,
        public userType?: TypeUser,
        public actionRange?: number,
        public availability?: boolean,
        public user?: User,
        public address?: Location,
    ) {
        this.availability = false;
    }
}
