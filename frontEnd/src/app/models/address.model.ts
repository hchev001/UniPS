/**
 * Provides model for Address object
 */

export class Address {
    constructor (
        private line1: String,
        private line2: String,
        private city: String,
        private state: String,
        private zip: number
    ) {}
}
