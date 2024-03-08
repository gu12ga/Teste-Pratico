import CryptoJS from 'crypto-js';

export class CriptogriaUtil {

    constructor() {}

    private key = CryptoJS.enc.Hex.parse("253D3FB468A0E24677C28A624BE0F939");
    private iv   = CryptoJS.enc.Hex.parse("00000000000000000000000000000000");

    encrypt(data: string): string {
        return CryptoJS.AES.encrypt(data, this.key, {iv: this.iv, padding: CryptoJS.pad.NoPadding}).toString();
    }

}