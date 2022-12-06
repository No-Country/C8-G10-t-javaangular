export interface IResponseAllBroadcastMedium {
	idBroadcastMedium: number;
	urImage: string;
	name: string;
	idPlatform: number;
	platform: string;
	urlPLatform: string;
	tagList: TagList[];
}

export interface TagList {
	idTag: number;
	description: string;
}
