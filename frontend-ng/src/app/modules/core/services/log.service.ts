import { Injectable } from '@angular/core';

export enum LogLevel {
  OFF   = 0,
  ERROR = 1,
  WARN  = 2,
  INFO  = 3,
  DEBUG = 4
}

@Injectable({
  providedIn: 'root'
})
export class LogService {
  level: LogLevel = LogLevel.DEBUG;

  constructor() {
  }

  error(message) {
    this.log(LogLevel.ERROR, message);
  }

  warn(message) {
    this.log(LogLevel.WARN, message);
  }

  info(message) {
    this.log(LogLevel.INFO, message);
  }

  debug(message) {
    this.log(LogLevel.DEBUG, message);
  }

  private log(level: LogLevel, message: string) {
    if (this.shouldLog(level)) {
      console.log(`${this.getDate()}: [${level}] ${message}`);
    }
  }

  private shouldLog(level: LogLevel): boolean {
    return level <= this.level;
  }

  private getDate(): string {
    // TODO: Use momentjs or other library for date format
    const current = new Date();
    // tslint:disable-next-line: max-line-length
    return `${current.getFullYear()}-${current.getMonth() + 1}-${current.getDate()} ${current.getHours()}:${current.getMinutes()}:${current.getSeconds()}`;
  }
}
