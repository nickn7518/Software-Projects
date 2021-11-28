% Nick Neal
% 05/19/2020
% Problem Set 3

% pt a
% Mean
stepsize = 1;
Mu = 1:stepsize:300;

% SD
variance = 20;
sd = sqrt(variance);

NormalRT = [50 70 30];

% Prior with unif distribution
Prior = ones(1,length(Mu))*(1/length(Mu));
Prior = Prior./sum(Prior);

% 2. Likelihood: compute the likelihood for each observation, and then comppute the product across observations 
for i=1:length(NormalRT)
    LikelihoodLoop(i,:) = normpdf(NormalRT(i),Mu,sd);
end
Likelihood = prod(LikelihoodLoop,1);

% 3. Compute the posterior distribution of mu
Posterior = Likelihood.*Prior;
Posterior = Posterior/sum(Posterior * stepsize);

figure;
plot(Mu,Posterior);

% Compute posterior b/w 45 & 50 (pt b)
PosteriorSum = sum(Posterior.*(Mu<=50 & Mu>=45))

% latent variable is Mu (pt c)
x4 = 1:stepsize:300;
for i=1:length(x4)
    prob(i)=sum(normpdf(x4(i),Mu,variance).*Posterior)*stepsize;
end
prob = prob/sum(prob*stepsize); % normalization

% Part D
figure;
plot(x4,prob);
hold on;
plot(Mu,Posterior);

% Part D Explanation
% It would seem that the x4 distribution is wider based off of the fact
% that x4 is an investigation of what the odds are that the fourth variable
% will be within a set range. While both distributions are normal and
% unimodal, the x4 one must cover a greater range of values to encompass
% all possibilities for what it could be, based off of the standard
% deviation. The posterior is much more narrow because it's based off of
% values that are already known, rather than the x4 graph being based off
% of the possibility of a latent, unobserved variable that is not known.
% The Mu graph takes in known values. The x4 considers latent ones.