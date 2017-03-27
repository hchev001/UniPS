/**
 * Provides a comment object
 */

import { User } from './user.model';

export class Comment {
    constructor(
        private creator: User,
        private subject: String,
        private body: String,
        private creationDate: String,
        private flag: String,
    ) {}
}
