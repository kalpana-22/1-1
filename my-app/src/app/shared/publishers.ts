import {Comment} from './comment';

export class Publisher {
    id: string;
    publication: string;
    name: string;
    image: string;
    logo: string;
    description: string;
    comments: Comment[];
}