import { UserProfile } from './user-profile.model';

export interface AuthenticatedUser {
  token: string;
  profile: UserProfile;
}
