export class User {
    public id: number;
    public username: string;
    public email: string;
    public password: string;
    public isAdmin: boolean;
    public documentIsApprovedByAdmin: boolean;
    public documentIsApprovedByUser: boolean;
    public document: Blob;
}
