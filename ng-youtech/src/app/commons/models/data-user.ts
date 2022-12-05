export interface IDataUser {
  fullName: string;
  isAdmin: boolean;
}

export interface IJwtDecode {
  email: string;
  name: string;
  lastName: string;
  admin: boolean;
}
