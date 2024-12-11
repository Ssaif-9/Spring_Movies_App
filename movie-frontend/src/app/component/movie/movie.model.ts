import { Rating } from "./rating.model";

export class MovieFullInfo{
    title: String = '';
    year : String = '';
    rated : String = '';
    released: String = '';
    runtime : String = '';
    genre : String = '';
    director: String = '';
    writer: String = '';
    poster: String = '';
    awards : String = '';
    country: String = '';
    language: String = '';
    plot: String = '';
    actors : String = '';
    response: String = '';
    website : String = '';
    production: String = '';
    boxoffice : String = '';
    dvd: String = '';
    type: String = '';
    imdbID: String = '';
    imdbvotes: String = '';
    imdbrating : String = '';
    metascore: String = '';
    ratings: Rating[] = [];
}