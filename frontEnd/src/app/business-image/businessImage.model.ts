/**
 * Model for business image component
 */

export class BussinessImage {
    constructor (
        private path: String
    ) {}

    getPath (): String  {
        return this.path;
    }
}
