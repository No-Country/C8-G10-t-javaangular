interface IPath {
  register: ConfigPath;
}

interface ConfigPath {
  readonly path: string;
  readonly pathWithSlash: string;
  readonly title: string;
}

export class PathWeb {
  private static pathAuthRegister = 'register';

  static readonly AUTH: IPath = {
    register: {
      path: this.pathAuthRegister,
      pathWithSlash: `/${this.pathAuthRegister}`,
      title: 'Registro',
    },
  };
}
