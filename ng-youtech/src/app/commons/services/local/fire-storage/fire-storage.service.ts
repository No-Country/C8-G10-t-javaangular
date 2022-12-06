import { Injectable } from '@angular/core';
import { getDownloadURL, ref, Storage, uploadBytes } from '@angular/fire/storage';
import { v4 as uuidv4 } from 'uuid';

@Injectable({ providedIn: 'root' })
export class FireStorageService {
	constructor(private _storage: Storage) {}

	async saveImage(file: File) {
		const imageRef = ref(this._storage, `images/${uuidv4()}`);
		await uploadBytes(imageRef, file);
		const url = await getDownloadURL(imageRef);
		return url;
	}
}
