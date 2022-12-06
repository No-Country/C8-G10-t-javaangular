import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';
import { IResponseContentCreator } from '../../../commons/services/api/content-creator/content-creator-api.interface';
import { ContentCreatorApiService } from '../../../commons/services/api/content-creator/content-creator-api.service';
import { DataUserService } from './../../../commons/services/local/data-user.service';

@Component({
	selector: 'app-profile-flow',
	templateUrl: './profile-flow.component.html',
	styleUrls: ['./profile-flow.component.scss']
})
export class ProfileFlowComponent implements OnInit {
	private _fileSelected!: File;
	imageSrc!: string;

	constructor(
		private _iconRegistry: MatIconRegistry,
		private _sanitizer: DomSanitizer,
		private _contentCreatorApiService: ContentCreatorApiService,
		private _dataUserService: DataUserService
	) {
		this._loadIcons();
	}

	formGroup = new FormGroup({
		name: new FormControl('', { nonNullable: true, validators: Validators.required }),
		lastName: new FormControl('', { nonNullable: true, validators: Validators.required }),
		pseudonym: new FormControl(''),
		email: new FormControl('', { nonNullable: true, validators: [Validators.required, Validators.email] }),
		password: new FormControl('', { nonNullable: true, validators: Validators.required }),
		urlGithub: new FormControl(''),
		urlTwitter: new FormControl(''),
		urlLinkedin: new FormControl('')
	});

	ngOnInit(): void {
		this.loadDataContentCreator();
	}

	onFileSelected(event: Event): void {
		const htmlInput: HTMLInputElement = event.target as HTMLInputElement;
		if (htmlInput && htmlInput.files && htmlInput.files.length > 0) {
			const reader = new FileReader();
			const file = htmlInput.files[0];
			this._fileSelected = file;

			reader.readAsDataURL(htmlInput.files[0]);
			reader.onload = () => {
				this.imageSrc = reader.result as string;
			};
		}
	}

	private loadDataContentCreator(): void {
		const idContentCreator = this._dataUserService.getDataUser()!.idContentCreator;
		this._contentCreatorApiService.getContentCreator(idContentCreator).subscribe((response) => {
			if (response.success) {
				this._loadFormValues(response.data);
			}
		});
	}

	private _loadFormValues(response: IResponseContentCreator) {
		this.formGroup.patchValue(response);
		if (response.imageProfile) {
			this.imageSrc = response.imageProfile;
		}
	}

	private _loadIcons() {
		this._iconRegistry.addSvgIcon('github', this._sanitizer.bypassSecurityTrustResourceUrl('assets/svg/gitHub.svg'));
		this._iconRegistry.addSvgIcon('twitter', this._sanitizer.bypassSecurityTrustResourceUrl('assets/svg/twitter.svg'));
		this._iconRegistry.addSvgIcon(
			'linkedIn',
			this._sanitizer.bypassSecurityTrustResourceUrl('assets/svg/linkedIn.svg')
		);
	}

	//#region Fields Contorls
	get firtsField(): FormControl<string> {
		return this.formGroup.controls.name;
	}

	get lastNameField(): FormControl<string> {
		return this.formGroup.controls.lastName;
	}

	get pseudonym(): FormControl<string | null> {
		return this.formGroup.controls.pseudonym;
	}
	get emailField(): FormControl<string> {
		return this.formGroup.controls.email;
	}

	get passwordField(): FormControl<string> {
		return this.formGroup.controls.password;
	}

	get urlGithubField(): FormControl<string | null> {
		return this.formGroup.controls.urlGithub;
	}

	get urlTwitterField(): FormControl<string | null> {
		return this.formGroup.controls.urlTwitter;
	}
	get urlLinkedinField(): FormControl<string | null> {
		return this.formGroup.controls.urlLinkedin;
	}
	//#endregion
}
