import {Comment} from './comment';

export class Publisher {
    id: string;
    username: string;
    email: string;
    password: string;
    name: string;
    image: string;
    logo: string;
    description: string;
    comments: Comment[];
}