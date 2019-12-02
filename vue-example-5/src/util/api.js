import {get, post} from "./http";
export const apiAddress = p => post('http://localhost:9000/new/list', p);
