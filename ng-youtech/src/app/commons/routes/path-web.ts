interface ConfigPath {
  readonly path: string;
  readonly pathWithSlash: string;
  readonly title: string;
}

export class PathWeb {
  private static pathAuthRegister = 'register';
  private static pathContentCreator = 'content-creator';
  private static pathAdministrator = 'administrator';

  static readonly AUTH: { register: ConfigPath } = {
    register: {
      path: this.pathAuthRegister,
      pathWithSlash: `/${this.pathAuthRegister}`,
      title: 'Registro',
    },
  };

  static readonly CONTENT_CREATOR: {
    readonly path: string;
    readonly pathWithSlash: string;
    profile: ConfigPath;
    broadcastMedium: ConfigPath;
  } = {
    path: this.pathContentCreator,
    pathWithSlash: `/${this.pathContentCreator}`,

    profile: {
      path: 'profile',
      pathWithSlash: `/${this.pathContentCreator}/profile`,
      title: 'Perfil',
    },
    broadcastMedium: {
      path: 'broadcast-medium',
      pathWithSlash: `/${this.pathContentCreator}/broadcast-medium`,
      title: 'Medios de difusión',
    },
  };

  static readonly ADMINISTRATOR: {
    readonly path: string;
    readonly pathWithSlash: string;
    contentCreator: ConfigPath;
    maintenance: ConfigPath;
  } = {
    path: this.pathAdministrator,
    pathWithSlash: `/${this.pathAdministrator}`,

    contentCreator: {
      path: 'content-creator',
      pathWithSlash: `/${this.pathAdministrator}/content-creator`,
      title: 'Creadores de contenido',
    },
    maintenance: {
      path: 'maintenance',
      pathWithSlash: `/${this.pathAdministrator}/maintenance`,
      title: 'Mantenimiento',
    },
  };
}
